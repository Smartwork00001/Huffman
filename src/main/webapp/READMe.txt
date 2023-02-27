1) How to upload files in the background?
	You need to use javascript fetch API
	Like so
	const done = await fetch('FileUpload', {
	    method: "POST", 
	    body: formData
	  }); 
	  alert("File Uploaded!");
	where FileUpload is the uri of the FileUpload servlet that will upload the file
	and formData = new FormData(document.forms.IDofTheForm);
	
2) How to download files from server
	Follow the tutorials online, they work, the problem why mine was not working for so long was because I tried to download 
	in the background same as uploading, but I actually needed to change the url to the DownloadServletUrl for it to work, 
	i.e. on cliking a button it should go to \DownloadFileServlet
	and being event.preventDefault()'ed in the javascript.