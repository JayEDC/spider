package com.xfj.spider.cache;

import com.xfj.spider.common.Constant;
import com.xfj.spider.mapper.EsfToolsSpiderProxyIpMapper;
import com.xfj.spider.model.EsfToolsSpiderProxyIp;
import com.xfj.spider.service.impl.SpiderRecordServiceImpl;
import com.xfj.spider.util.HttpUtil;
import com.xfj.spider.util.SpringUtil;
import org.apache.http.HttpHost;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.protocol.HttpContext;
import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.*;

/**
 * @ClassName IPDataCache
 * @Description //TODO
 * @Author xnc lee
 * @Date 2018/12/43:22 PM
 * @return 1.0
 **/
public class IPDataCache {

    static Logger logger = LoggerFactory.getLogger(IPDataCache.class);


    public  static ArrayList<EsfToolsSpiderProxyIp> proxyIpCache = new ArrayList<EsfToolsSpiderProxyIp>();
    public  static ArrayList<EsfToolsSpiderProxyIp> proxyIpCacheforJump58 = new ArrayList<EsfToolsSpiderProxyIp>();
    public  static ArrayList<EsfToolsSpiderProxyIp> proxyIpCacheforZh58 = new ArrayList<EsfToolsSpiderProxyIp>();
    public  static ArrayList<EsfToolsSpiderProxyIp> proxyIpCacheforShort58 = new ArrayList<EsfToolsSpiderProxyIp>();

    public static EsfToolsSpiderProxyIpMapper esfToolsSpiderProxyIpMapper;
    public static SpiderRecordServiceImpl spiderRecordService;
    static{

        System.setProperty("org.apache.commons.logging.Log", "org.apache.commons.logging.impl.SimpleLog");
        System.setProperty("org.apache.commons.logging.simplelog.showdatetime", "true");
        System.setProperty("org.apache.commons.logging.simplelog.log.org.apache.commons.httpclient", "stdout");

        esfToolsSpiderProxyIpMapper = SpringUtil.getBean(EsfToolsSpiderProxyIpMapper.class);
        spiderRecordService = SpringUtil.getBean(SpiderRecordServiceImpl.class);
//        initIpCatch();
    }
    public static void  initIpCatch(){
        delNotFastProxyIp();
        //spiderRecordService.loadLocalProxyIp();
        spiderRecordService.loadProxyIp();
        filterAvailable();
    }


    private static HttpRequestRetryHandler myRetryHandler = new HttpRequestRetryHandler() {
        @Override
        public boolean retryRequest(IOException exception, int executionCount, HttpContext context) {
            return false;
        }};



    public static void  loadProxyIp  (EsfToolsSpiderProxyIp esfToolsSpiderProxyIp,String ipPoolName){
        if (ipPoolName.equals("proxyIpCacheforJump58") && (!proxyIpCacheforJump58.contains(esfToolsSpiderProxyIp))){
            proxyIpCacheforJump58.add(esfToolsSpiderProxyIp);
            logger.info("加入proxyIpCacheforJump58池成功"+",当前数量为："+proxyIpCacheforJump58.size());
            return;
        }

        if (ipPoolName.equals("proxyIpCache") && (!proxyIpCache.contains(esfToolsSpiderProxyIp))){
            proxyIpCache.add(esfToolsSpiderProxyIp);
            logger.info("加入proxyIpCache池成功"+",当前数量为："+proxyIpCache.size());
            return;
        }

        if (ipPoolName.equals("proxyIpCacheforZh58") && (!proxyIpCacheforZh58.contains(esfToolsSpiderProxyIp))){
            proxyIpCacheforZh58.add(esfToolsSpiderProxyIp);
            logger.info("加入proxyIpCacheforZh58池成功"+",当前数量为："+proxyIpCacheforZh58.size());
            return;
        }

        if (ipPoolName.equals("proxyIpCacheforShort58") && (!proxyIpCacheforShort58.contains(esfToolsSpiderProxyIp))){
            proxyIpCacheforShort58.add(esfToolsSpiderProxyIp);
            logger.info("加入proxyIpCacheforShort58池成功"+",当前数量为："+proxyIpCacheforShort58.size());
            return;
        }


    }

    /**
     * 加载代理IP至缓存
     */
    public static void loadProxyIp(){

        String str = null;
        try {
            str = HttpUtil.getData(Constant.GET_PROXY_IP_URL);
            JSONObject object =  new JSONObject(str);
            JSONObject data = object.getJSONObject("data");
            JSONArray proxyList = data.getJSONArray("proxy_list");

            for(int i=0;i< proxyList.length();i++){
                String proxyIp = (String) proxyList.get(i);
                String ipAddress = proxyIp.split(":")[0];
                EsfToolsSpiderProxyIp spiderProxyIp = new EsfToolsSpiderProxyIp();

                Integer port = Integer.parseInt(proxyIp.split(":")[1]);

                spiderProxyIp.setIpAddr(ipAddress);
                spiderProxyIp.setIpPort(port);

                //如果原有集合中含有该IP和端口号，则不重复添加
                if(proxyIpCache.contains(spiderProxyIp)){
                    continue;
                }
                proxyIpCache.add(spiderProxyIp);

            }
            logger.info("加载代理IP至缓存："+proxyIpCache);
        } catch (Exception e) {
            logger.error("加载代理IP至缓存发生异常："+e.getMessage());
            e.printStackTrace();
        }
    }

    public static List loadLocalProxyIp(){
        proxyIpCache.clear();
        List<EsfToolsSpiderProxyIp> list = esfToolsSpiderProxyIpMapper.getFastProxyIpAll();
        proxyIpCache.addAll(list);
      /*  Map map = new HashMap();
        map.put("当前缓存中的代理ip",proxyIpCache);*/
        System.out.println("定时器执行了");
        return   proxyIpCache;
    }

    /**
     * 随机获取代理缓存中的IP地址信息
     * @return
     */
    public static EsfToolsSpiderProxyIp getRandomProxyIp(){
        if(proxyIpCache!=null && proxyIpCache.size()>0){
            int arrSize = proxyIpCache.size();
            return proxyIpCache.get((int) (Math.random()*arrSize));
        }
        else{
            return null;
        }
    }

    /**
     * 返回所有缓存中的IP地址信息
     * @return
     */
    public static ArrayList<EsfToolsSpiderProxyIp> getProxyList(){
        return proxyIpCache;
    }

    /**
     * 随机获取代理缓存中的IP地址信息
     * @return
     */
    public static EsfToolsSpiderProxyIp getRandomProxyIpforZh58(){
        if(proxyIpCacheforZh58!=null && proxyIpCacheforZh58.size()>0){
            int arrSize = proxyIpCacheforZh58.size();
            return proxyIpCacheforZh58.get((int) (Math.random()*arrSize));
        }
        else{
            return null;
        }
    }

    /**
     * 随机获取代理缓存中的IP地址信息
     * @return
     */
    public static EsfToolsSpiderProxyIp getRandomProxyIpforJump58(){
        if(proxyIpCacheforJump58!=null && proxyIpCacheforJump58.size()>0){
            int arrSize = proxyIpCacheforJump58.size();
            return proxyIpCacheforJump58.get((int) (Math.random()*arrSize));
        }
        else{
            return null;
        }
    }

    /**
     * 随机获取代理缓存中的IP地址信息
     * @return
     */
    public static EsfToolsSpiderProxyIp getRandomProxyIpforShort58(){
        if(proxyIpCacheforShort58!=null && proxyIpCacheforShort58.size()>0){
            int arrSize = proxyIpCacheforShort58.size();
            return proxyIpCacheforShort58.get((int) (Math.random()*arrSize));
        }
        else{
            return null;
        }
    }


    private static String getRandomTestAddr(){
        String [] arr = Constant.TEST_ADDR ;
        int arrSize = arr.length;
        return arr[(int) (Math.random()*arrSize)];
    }

    /**
     * 过滤不可用的代理IP

     * @return
     */
    public static Map filterAvailable(){

        //检测
        List<EsfToolsSpiderProxyIp> spiderProxyIpList = new ArrayList<EsfToolsSpiderProxyIp>();
        String ip;
        Integer port;

        CloseableHttpClient httpClient = HttpClients.custom().setRetryHandler(myRetryHandler).build();
        CloseableHttpResponse response = null;
        ArrayList<EsfToolsSpiderProxyIp> ipCacheList = proxyIpCache;



        logger.info("原代理池ip数量："+ ipCacheList.size());
        for(int i = 0; i < ipCacheList.size(); i++) {
            EsfToolsSpiderProxyIp proxyIpTemp = ipCacheList.get(i);
            ip = proxyIpTemp.getIpAddr();
            port = proxyIpTemp.getIpPort();

            HttpHost proxy = new HttpHost(ip, port);
            RequestConfig config = RequestConfig.custom().setProxy(proxy).setConnectionRequestTimeout(Constant.CONNECT_TIME_OUT).setConnectTimeout(Constant.CONNECT_TIME_OUT).
                    setSocketTimeout(Constant.CONNECT_TIME_OUT).build();
            String testAddr = getRandomTestAddr();
            HttpGet httpGet = new HttpGet(testAddr);
            httpGet.setConfig(config);

            httpGet.setHeader("Accept", "text/html,application/xhtml+xml,application/xml;" +
                    "q=0.9,image/webp,*/*;q=0.8");
            httpGet.setHeader("Accept-Encoding", "gzip, deflate, sdch");
            httpGet.setHeader("Accept-Language", "zh-CN,zh;q=0.8");
            httpGet.setHeader("User-Agent", "Mozilla/5.0 (X11; Linux x86_64) AppleWebKit" +
                    "/537.36 (KHTML, like Gecko) Chrome/55.0.2883.87 Safari/537.36");

            try {
                response = httpClient.execute(httpGet);
            } catch (IOException e) {
                logger.error(("不可用代理已删除" + ipCacheList.get(i).getIpAddr() + ": " + ipCacheList.get(i).getIpPort()));
                EsfToolsSpiderProxyIp temp = ipCacheList.get(i);
                ipCacheList.remove(temp);
                if(proxyIpCacheforZh58.contains(temp)){
                    proxyIpCacheforZh58.remove(temp);
                }
                if(proxyIpCacheforJump58.contains(temp)){
                    proxyIpCacheforJump58.remove(temp);
                }
                if(proxyIpCacheforShort58.contains(temp)){
                    proxyIpCacheforShort58.remove(temp);
                }
                esfToolsSpiderProxyIpMapper.delete(temp);
                logger.info("当前可用代理IP:"+ipCacheList);
            }
        }

        logger.info("检测后代理池ip数量："+ ipCacheList.size());


        List<EsfToolsSpiderProxyIp> list = esfToolsSpiderProxyIpMapper.selectAll();

        a: for(EsfToolsSpiderProxyIp model : ipCacheList){
            for(int i=0;i<list.size();i++){

                String ipAddrTemp = list.get(i).getIpAddr();
                int ipPortTemp = list.get(i).getIpPort();

                String modelIpAddr = model.getIpAddr();
                int modelIpPort = model.getIpPort();

                if(ipAddrTemp.equals(modelIpAddr) && ipPortTemp== modelIpPort){
                    list.get(i).setSuccessedCount(list.get(i).getSuccessedCount()+1);
                    list.get(i).setSuccessTime(new Date());
                    esfToolsSpiderProxyIpMapper.updateByPrimaryKey( list.get(i));
                    continue a;
                }

            }

            model.setCreateTime(new Date());
            model.setSuccessedCount(0);
            model.setFailedCount(0);
            spiderProxyIpList.add(model);
        }
        //插入新检测可用的IP
        if(spiderProxyIpList!=null && spiderProxyIpList.size()>0) {
            esfToolsSpiderProxyIpMapper.insertList(spiderProxyIpList);
        }
        try {
            httpClient.close();
            if(response != null){
                response.close();
            }

        } catch (IOException e) {
            logger.error("过滤不可用的代理IP发生异常:"+e.getMessage());
            e.printStackTrace();
        }
        Map map = new HashMap();
        map.put("更新后缓存中的代理IP",ipCacheList);
        return map;
    }

    public static int delNotFastProxyIp(){
        //删除代理库表池中速度较慢的IP
        logger.info("删除代理池中速度较慢的IP");
        int delNotFastSize = esfToolsSpiderProxyIpMapper.delNotFastProxyIp();
        //重新从库表读取缓存
//        loadLocalProxyIp();
        logger.info("速度较慢IP删除数量："+delNotFastSize);
        return delNotFastSize;
    }

}
