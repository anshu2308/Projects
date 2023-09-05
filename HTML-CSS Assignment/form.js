
function nameValidation() {
    var name = document.getElementById("Name").value;
    
    if (name.trim() == "" || name.length < 3 || name.length > 20) {
        document.getElementById("InvalidName").style.visibility="visible";
        Name.style.border = "solid 2px red";
         return false;
    }
    else{
        Name.style.border="solid 1px black";
        document.getElementById("InvalidName").style.visibility="hidden"
         return emailValidation();
    }
}
function emailValidation(){
    var email = document.getElementById("Email").value;
    var valid_Email = /^([a-zA-Z0-9\.-]+)@([a-zA-Z0-9-]+).([a-z]{2,20})$/;
    if(valid_Email.test(email)){
        Email.style.border = "solid 1px black";
        document.getElementById("InvalidEmail").style.visibility = "hidden"
        return  websiteValidation();
    }
    else{
        document.getElementById("InvalidEmail").style.visibility = "visible";
        Email.style.border = "solid 2px red";
         return false;
    }
}
function websiteValidation(){
    var website=document.getElementById("websiteUrl").value;
    let url;
    try {
        url = new URL(website);
    } catch (_) {
        document.getElementById("InvalidWebsite").style.visibility = "visible";
        websiteUrl.style.border = "solid 2px red";
         return false;
    }
    if( url.protocol === "http:" || url.protocol === "https:")
  {
        websiteUrl.style.border = "solid 1px black";
        document.getElementById("InvalidWebsite").style.visibility = "hidden";
         return ImageValidation();
       
  }
 
}
function ImageValidation(){
    var image=document.getElementById("imageLink").value;
    var dotPos=image.lastIndexOf(".")+1;
    var ext=image.substr(dotPos,image.length).toLowerCase();
    
    if(ext=="jpg" || ext=="png" || ext=="jpeg" || ext=="jfif")
    {
        document.getElementById("InvalidImage").style.visibility = "hidden";
        imageLink.style.border = "solid 1px black";
        return submitForm();
    }
    else{
        document.getElementById("InvalidImage").style.visibility = "visible";
        imageLink.style.border = "solid 2px red";
           return false;
    }
}

function submitForm(){
    var name = document.getElementById("Name").value;
    var email = document.getElementById("Email").value;
    var website = document.getElementById("websiteUrl").value;
    var image = document.getElementById("imageLink").value;
    var gender = document.querySelector('input[name="Gender"]:checked').id;
    var checkboxes = document.querySelectorAll('input[name="Skills"]:checked');
    var str="";
    for(i=0;i<checkboxes.length;i++)
    {
            str+=checkboxes[i].value+", ";   
    }

    var display=document.getElementById("display");
    display.style.visibility = "visible";
    var newRow=display.insertRow();
    newRow.className="newenroll";
    var cell1=newRow.insertCell(0);
    var cell2=newRow.insertCell(1);
    cell1.colSpan="2";
    cell1.innerHTML = '<b>' + name + '</b><br>'+gender+'<br>'+email+'<br><a target="_blank" href="' + website + '">'+website+'</a><br>'+str;
    cell2.innerHTML='<img src="'+image+'" alt="Student Photo"></img>';
    
   
     return false;
    
} 



