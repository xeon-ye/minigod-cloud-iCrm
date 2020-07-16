
function pictureList(filePath , index) {

    var url = webRoot + "/common/downloadFile?fullFilePath=" + encodeURIComponent(filePath)+"&"+Math.random();
    var html = "<img src ='" + url + "' data-original='" + url + "'/>";
    var li = document.createElement('li');
    li.id = "img_list" + index;
    li.innerHTML = html;
    var p = document.querySelector('#imageList ul');
    p.appendChild(li)
}

function showAccountOpenImg(index) {
    var id = "#img_list" + index;
    var image = $(id).find("img");
    image.click();
}

function pictureListWithId(filePath , index,id) {

    var url = webRoot + "/common/downloadFile?fullFilePath=" + encodeURIComponent(filePath)+"&"+Math.random();
    var html = "<img src ='" + url + "' data-original='" + url + "'/>";
    var li = document.createElement('li');
    li.id = "img_list"+id+ index;
    li.innerHTML = html;
    var seleId='imageList'+id+' ul';
    var p = document.querySelector('#'+seleId);
    p.appendChild(li)
}

function showImage(id,index) {
    var id = "#img_list" +id+ index;
    var image = $(id).find("img");
    image.click();
}