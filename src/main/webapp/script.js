/* Compression JavaScript */
const submitButtonUncompressed = document.querySelector("#submitButtonUncompressed");
const compressFile = document.getElementById("compressFile");
const downloadCompressedFile = document.getElementById("downloadCompressedFile");

const uncompressedFormHandler = async function(event){
    event.preventDefault();
    const form = document.forms.uncompressedForm;
    const formData = new FormData(form);
    const done = await fetch('FileUpload', {
	    method: "POST", 
	    body: formData
	  }); 
	  alert("File Uploaded!")
}

const compressFileHandler = async function(event){
    event.preventDefault();
    const done  = await fetch('Compress', {
        method: "GET"
    });
    if(downloadCompressedFile.classList.contains("hidden")){
        downloadCompressedFile.classList.remove("hidden");
    }
}

submitButtonUncompressed.addEventListener("click",uncompressedFormHandler);
compressFile.addEventListener("click",compressFileHandler);
/* End of Compression */
/* Start of decompression */
const submitButtonCompressed = document.querySelector("#submitButtonCompressed");
const decompressFile = document.getElementById("decompressFile");
const downloadDecompressedFile = document.getElementById("downloadDecompressedFile");

const compressedFormHandler = async function(event){
    event.preventDefault();
    const form = document.forms.compressedForm;
    const formData = new FormData(form);
    const done = await fetch('FileUpload', {
	    method: "POST", 
	    body: formData
	  }); 
	  alert("File Uploaded!")
}

const decompressFileHandler = async function(event){
    event.preventDefault();
    const done  = await fetch('Decompress', {
        method: "GET"
    });
    if(downloadDecompressedFile.classList.contains("hidden")){
        downloadDecompressedFile.classList.remove("hidden");
    }
}


submitButtonCompressed.addEventListener("click",compressedFormHandler);
decompressFile.addEventListener("click",decompressFileHandler);
