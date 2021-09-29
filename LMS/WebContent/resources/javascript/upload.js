function uploadFiles(uploadPathKey, urlsId, linksId, contextPath){
	strDialogOptions = 'center=yes;dialogWidth=800px;dialogHeight=600px;help=no;';		            
	ret = window.showModalDialog(contextPath+"/Upload/FileUpload.jsf?uploadPathKey=" + uploadPathKey, null, strDialogOptions);
	if(ret != null){
		document.getElementById(urlsId).value = ret[0];
		adjustUploads(ret[0], linksId);    
	}
	else{
		document.getElementById(urlsId).value = '';
		adjustUploads('', linksId); 
    }
}
 
function adjustUploads(urls, linksId){
	if(urls == null|| urls == ''){
		document.getElementById(linksId).innerHTML= '';
		return;
	}
	
	var urlsArray = urls.split(',');
	var htmlLinks = '';
	var comma = '';
	for(var j=0 ; j < urlsArray.length ; j++){
		var fileURL= urlsArray[j];
		var tokens = fileURL.split('/');
		var fileName = tokens[tokens.length-1];
		fileName = fileName.substring(0, fileName.lastIndexOf("_")) + fileName.substring(fileName.lastIndexOf("."), fileName.length);
		fileName = fileName.replace(/%20/g, ' ');		
		htmlLinks += comma + '<a href="'+fileURL+'">'+fileName+'</a>';		
		comma = ' , ';
	}
	document.getElementById(linksId).innerHTML= htmlLinks;
}

function finishUploads(){
    returnVal = new Array();
    returnVal[0] = document.getElementById('fileUploadForm:attachementsId').value;
    window.returnValue = returnVal;
    window.close();
}