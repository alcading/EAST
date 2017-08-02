_SHOW_FLAG = false;
//MODIFY BMS-2142
DWREngine.setErrorHandler(
	function errh(errorString,exception){
		if(typeof(exception)=="object"){
			if(exception.name == "GD0101"){
				//GD0101=操作员无此功能权限
				errAlert(errorString);
				top.location.href = _application_root;
				errAlert = function(){};
			}else if(exception.name == "GD0102"){
				//GD0102=操作员会话无效
				errAlert(errorString);
				top.location.href = _application_root;
				errAlert = function(){};
			}else if(exception.name == "GD0103"){
				//GD0103=此会话已经被其他操作员绑定
				errAlert(errorString);
				top.location.href = _application_root;
				errAlert = function(){};
			}else{
				errAlert(errorString);
			}
		}else{
			errAlert(errorString);
		}
	}
);
//END BMS-2142
//This is fairly simple and makes it quite easy to implement your own "loading" message.
function useLoadingMessage(message) {
  var loadingMessage;
  if (message) loadingMessage = message;
  else loadingMessage = "Loading";
  DWREngine.setPreHook(function() {
    var disabledZone = $('disabledZone');
    if (!disabledZone) {
      disabledZone = document.createElement('div');
      disabledZone.setAttribute('id', 'disabledZone');
      disabledZone.style.position = "absolute";
      disabledZone.style.zIndex = "1000";
      disabledZone.style.left = "0px";
      disabledZone.style.top = "0px";
      disabledZone.style.width = "100%";
      disabledZone.style.height = "100%";
      document.body.appendChild(disabledZone);
      var messageZone = document.createElement('div');
      messageZone.setAttribute('id', 'messageZone');
      messageZone.style.position = "absolute";
      messageZone.style.top = "0px";
      messageZone.style.right = "0px";
      messageZone.style.background = "red";
      messageZone.style.color = "white";
      messageZone.style.fontFamily = "Arial,Helvetica,sans-serif";
      messageZone.style.padding = "4px";
      disabledZone.appendChild(messageZone);
      var text = document.createTextNode(loadingMessage);
      messageZone.appendChild(text);
    }
    else {
      $('messageZone').innerHTML = loadingMessage;
      disabledZone.style.visibility = 'visible';
    }
  });

  DWREngine.setPostHook(function() {
    $('disabledZone').style.visibility = 'hidden';
  });
}

function useLoadingImage(imageSrc) {
  var loadingImage;
  if (imageSrc) loadingImage = imageSrc;
  else loadingImage = "ajax-loader.gif";
  DWREngine.setPreHook(function(){funPreHook(imageSrc);});
  DWREngine.setPostHook(funPostHook);
}

function funPostHook(targetDoc){
 //document.body.style.backgroundColor = '#FFFFFF';
 //document.body.removeChild($('imageZone'));
 //document.body.removeChild($('disabledImageZone'));
 var _document = targetDoc;
 if(!_document){
 	_document = document;
 }
 _document.getElementById('disabledImageZone').style.visibility = 'hidden';
 _document.getElementById('imageZone').style.visibility = 'hidden';
 _document.getElementById('imageZone').style.top = 0;
 _document.getElementById('disabledImageZone').style.width = 0;
 _document.getElementById('disabledImageZone').style.height = 0;
}
function funPreHook(imageSrc, targetDoc) {
    //document.body.style.backgroundColor = '#EEEEEE';
    var _document = targetDoc;
    if(!_document){
    	_document = document;
    }
    var disabledImageZone = _document.getElementById("disabledImageZone");
    if (!disabledImageZone) {
      disabledImageZone = _document.createElement('div');
      disabledImageZone.setAttribute('id', 'disabledImageZone');
      disabledImageZone.style.backgroundColor = '#FFFFFF';
      disabledImageZone.style.position = "absolute";
      disabledImageZone.style.zIndex = "10001";
      disabledImageZone.style.left = "0px";
      disabledImageZone.style.top = "0px";
      disabledImageZone.style.width = winsize().width + "px";//_document.body.scrollLeft + _document.body.scrollWidth;
	  disabledImageZone.style.height = winsize().height + "px";//_document.body.scrollHeight + _document.body.scrollTop;
      disabledImageZone.style.filter = "alpha(opacity=20)";
      disabledImageZone.style.opacity= 0.2;
      var imageZone = _document.createElement('img');
      imageZone.setAttribute('id','imageZone');
      imageZone.setAttribute('src',imageSrc);
      imageZone.style.position = "absolute";
      imageZone.style.zIndex = "10002";
      imageZone.style.backgroundColor = '#FFFFFF';
      imageZone.style.width = "32";
      imageZone.style.height = "32";
//      imageZone.style.left = (_document.body.offsetWidth-parseInt(imageZone.style.width))/2;
//      imageZone.style.top =(_document.body.scrollTop+(_document.body.clientHeight-imageZone.offsetHeight)/2);
      imageZone.style.top = ($(window).height() - $(imageZone).height()) / 2 + $(document).scrollTop() + "px"; 
      imageZone.style.left = ($(window).width() - $(imageZone).width()) / 2 + $(document).scrollLeft() + "px"; 

      _document.body.appendChild(disabledImageZone);
      _document.body.appendChild(imageZone);
      disabledImageZone.style.visibility = 'visible';
      imageZone.style.visibility = 'visible';
      disabledImageZone.style.display = "";
      imageZone.style.display = "";
    }
    else {
    	v_imageZone = _document.getElementById("imageZone");
      if(v_imageZone){
      	v_imageZone.style.top =($(window).height() - $(v_imageZone).height()) / 2 + $(document).scrollTop() + "px"; 
        disabledImageZone.style.width = winsize().width + "px";//_document.body.scrollLeft + _document.body.scrollWidth;
  	    disabledImageZone.style.height = winsize().height + "px";//_document.body.scrollHeight + _document.body.scrollTop;
   	    disabledImageZone.style.visibility = 'visible';
   	    v_imageZone.style.visibility = 'visible';
   	   }
    }
  }

function showLoadingImage(imageSrc,isshow) {
  var loadingImage;
  if (imageSrc) loadingImage = imageSrc;
  else loadingImage = "ajax-loader.gif";
  if( isshow ){
   document.body.style.backgroundColor = '#EEEEEE';
    var disabledImageZone = $('disabledImageZone');
    if (!disabledImageZone) {
      disabledImageZone = document.createElement('div');
      disabledImageZone.setAttribute('id', 'disabledImageZone');
      disabledImageZone.style.position = "absolute";
      disabledImageZone.style.zIndex = "1000";

      var imageZone = document.createElement('img');
      imageZone.setAttribute('id','imageZone');
      imageZone.setAttribute('src',imageSrc);
      imageZone.style.position = "absolute";
      imageZone.style.top = "0px";
      imageZone.style.right = "0px";
      imageZone.style.width = "32";
      imageZone.style.height = "32";
      disabledImageZone.appendChild(imageZone);

      disabledImageZone.style.width = imageZone.style.width;
      disabledImageZone.style.height = imageZone.style.height;
      disabledImageZone.style.left = (document.body.offsetWidth-parseInt(disabledImageZone.style.width))/2;
      disabledImageZone.style.top = (document.body.offsetHeight-parseInt(disabledImageZone.style.height))/2;
      document.body.appendChild(disabledImageZone);
    }
    else {
      $('imageZone').src = imageSrc;
      disabledImageZone.style.visibility = 'visible';
    }
   }else{
    document.body.style.backgroundColor = '#FFFFFF';
    $('disabledImageZone').style.visibility = 'hidden';
    }
}



function showPageLoadingImage(imageSrc,isshow) {
  var loadingImage;
  if( !imageSrc ){
  	loadingImage =  "/pageloading.gif";
  }else{
  	loadingImage = imageSrc;
  }
  if( isshow ){
   document.body.style.backgroundColor = '#EEEEEE';
    var disabledImageZone = document.getElementById('disabledLoadingImageZone');
    if (!disabledImageZone) {
      disabledImageZone = document.createElement('div');
      disabledImageZone.setAttribute('id', 'disabledImageZone');
      disabledImageZone.style.position = "absolute";
      disabledImageZone.style.zIndex = "1000";

      var imageZone = document.createElement('img');
      imageZone.setAttribute('id','imageZone');
      imageZone.setAttribute('src',loadingImage);
      imageZone.style.position = "absolute";
      imageZone.style.top = "0px";
      imageZone.style.right = "0px";
      imageZone.style.width = "214";
      imageZone.style.height = "15";
      disabledImageZone.appendChild(imageZone);

      disabledImageZone.style.width = imageZone.style.width;
      disabledImageZone.style.height = imageZone.style.height;
      disabledImageZone.style.left = (document.body.offsetWidth-parseInt(disabledImageZone.style.width))/2;
      disabledImageZone.style.top = (document.body.offsetHeight-parseInt(disabledImageZone.style.height))/2;
      document.body.appendChild(disabledImageZone);
    }
    else {
      document.getElementById('imageZone').src = loadingImage;
      disabledImageZone.style.visibility = 'visible';
    }
   }else{
    document.body.style.backgroundColor = '#FFFFFF';
    document.getElementById('disabledLoadingImageZone').style.visibility = 'hidden';
    }
}