/**
 * tinyImgUpload
 * @param ele [string] [生成组件的元素的选择器]
 * @param options [Object] [对组件设置的基本参数]
 * options具体参数如下
 * path 图片上传的地址路径 必需
 * onSuccess(res) 文件上传成功后的回调 参数为返回的文本 必需
 * onFailure(res) 文件上传失败后的回调 参数为返回的文本 必需
 * @return [function] [执行图片上传的函数]
 * 调用方法
 * tinyImgUpload('div', options)
 */
function tinyImgUpload(ele, options) {
    // 判断容器元素合理性并且添加基础元素
    var eleList = document.querySelectorAll(ele);
    if(eleList.length == 0){
        console.log('绑定的元素不存在');
        return;
    }else if(eleList.length>1){
        console.log('请绑定唯一元素');
        return;
    }else {
        var num = options &&  options.num ?  options.num : 10;
            eleList[0].innerHTML ='<div id="img-container" class="img-container">'+
                '<div class="img-up-add  img-item"><span class="img-add-icon">+</span></div>'+
                '<input type="file" name="files" id="img-file-input" class="img-file-input" multiple num=" '+ num +' ">'+
                '</div>';
        var ele = eleList[0].querySelector('.img-container');
        ele.files = [];   // 当前上传的文件数组
    }

    // 为添加按钮绑定点击事件，设置选择图片的功能
    var addBtn = $(ele).find('.img-up-add')[0];
    // document.querySelector('.img-up-add');

    $(ele).find('.img-up-add').click(function () {
        $(ele).find('.img-file-input').val(null);
        $(ele).find('.img-file-input').click();
        return false;
    });

    $(ele).find('.img-file-input').change(function(evt) {
        handleFileSelect(evt);
    });


    // document.querySelector('#img-file-input').addEventListener('change', handleFileSelect, false);


    // addBtn.addEventListener('click',function () {
    //     document.querySelector('#img-file-input').value = null;
    //     document.querySelector('#img-file-input').click();
    //     return false;
    // },false)

    // 预览图片
    //处理input选择的图片
    function handleFileSelect(evt) {
        var files = evt.target.files;

        var maxLength =  $(evt.target).attr("num");
        console.log($(evt.target));
        for(var i=0, f; f=files[i];i++){
            // 过滤掉非图片类型文件
            if(!f.type.match('image.*')){
                continue;
            }
            // 过滤掉重复上传的图片
            var tip = false;
            for(var j=0; j<(ele.files).length; j++){
                if((ele.files)[j].name == f.name){
                    tip = true;
                    break;
                }
            }
            if(!tip){
                if((ele.files).length > maxLength){
                    parent.layer.alert('图片不可超过'+maxLength+'张！');
                    return;
                }
                // 图片文件绑定到容器元素上
                ele.files.push(f);

                var reader = new FileReader();
                reader.onload = (function (theFile) {
                    return function (e) {
                        var oDiv = document.createElement('div');
                        oDiv.className = 'img-thumb img-item';
                        // 向图片容器里添加元素
                        oDiv.innerHTML = '<a class="showImg"  data-toggle="modal" data-target="#showImg"><img class="thumb-icon" src="'+e.target.result+'" /></a>'+
                                        '<input style="margin-left: 35px" type="button" href="javscript:;" class="remove" value="删除"/>'
                        ele.insertBefore(oDiv, addBtn);
                    };
                })(f);

                reader.readAsDataURL(f);
            }
        }
    }


    // 删除图片
    function removeImg(evt) {
        if(evt.target.className.match(/remove/)){
            console.log('3',ele.files);
            // 获取删除的节点的索引
            function getIndex(ele){

                if(ele && ele.nodeType && ele.nodeType == 1) {
                    var oParent = ele.parentNode;
                    var oChilds = oParent.children;
                    for(var i = 0; i < oChilds.length; i++){
                        if(oChilds[i] == ele)
                            return i;
                    }
                }else {
                    return -1;
                }
            }
            // 根据索引删除指定的文件对象
            var index = getIndex(evt.target.parentNode);
            ele.removeChild(evt.target.parentNode);
            if(index < 0){
                return;
            }else {
                ele.files.splice(index, 1);
            }
            console.log('4',ele.files);
        }
    }
    ele.addEventListener('click', removeImg, false);

    // 上传图片
    function uploadImg(type) {
        var xhr = new XMLHttpRequest();
        var formData = new FormData();

        for(var i=0, f; f=ele.files[i]; i++){
            formData.append('files', f);
        }

        console.log('1',ele.files);
        console.log('2',formData);

        xhr.onreadystatechange = function (e) {
            if(xhr.readyState == 4){
                if(xhr.status == 200){
                    options.onSuccess(xhr.responseText,type);
                }else {
                    options.onFailure(xhr.responseText);
                }
            }
        }

        xhr.open('POST', options.path, true);
        xhr.send(formData);

    }
    return uploadImg;
}

