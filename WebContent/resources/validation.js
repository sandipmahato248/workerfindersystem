function validateForm(){
	
	if (document.form.uname.value==""){
		alert("username should not be left blank");
		document.form.uname.focus();
		return false;
	}else if (document.form.pass.value.search(/^(?=.*\d)(?=.*[a-zA-Z])[a-zA-Z0-9]{7,}$/)){
		alert("password doesnot match");
		return false;
	}
}
	