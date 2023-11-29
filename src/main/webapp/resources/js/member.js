function focusIt(){      
   document.inform.id.focus();
}
 
function checkIt(){
   inputForm=eval("document.inform");
   if(!inputForm.id.value){
     alert("아이디를 입력하세요..");
	 inputForm.id.focus();
	 return false;
   }
   if(!inputForm.passwd.value){
     alert("비밀번호를 입력하세요..");
	 inputForm.passwd.focus();
	 return false;
   }
}



function modifyCheckIt() {
    var userinput = eval("document.userinput");
           
    if(!userinput.passwd.value ) {
        alert("비밀번호를 입력하세요");
        return false;
    }
    if(userinput.passwd.value != userinput.passwd2.value)
    {
        alert("비밀번호를 동일하게 입력하세요");
        return false;
    }
   
    if(!userinput.name.value) {
        alert("사용자 이름을 입력하세요");
        return false;
    }
    if(!userinput.jumin1.value  || !userinput.jumin2.value )
    {
        alert("주민등록번호를 입력하세요");
        return false;
    }
}

function begin(){
	document.myform.passwd.focus();
}

function deleteCheckIt(){
	if(!document.myform.passwd.value){
		alert("비밀번호를 입력하지 않으셨습니다.");
       	document.myform.passwd.focus();
       	return false;
	}
}
	