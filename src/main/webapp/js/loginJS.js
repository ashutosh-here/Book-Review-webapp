
document.getElementById('see-button').addEventListener('click', evt => {
	document.getElementById('blur-work').style.display = 'none';
})
  
  
  
     
    function onSignIn(googleUser) {
        console.log("ONSignIn");
  var profile = googleUser.getBasicProfile();
  console.log('ID: ' + profile.getId()); // Do not send to your backend! Use an ID token instead.
  console.log('Name: ' + profile.getName());
  console.log('Image URL: ' + profile.getImageUrl());
  console.log('Email: ' + profile.getEmail()); // This is null if the 'email' scope is not present.
  
  
    var id_token = googleUser.getAuthResponse().id_token;
var xhr = new XMLHttpRequest();
xhr.open('POST', 'GoogleAuthServlet');
xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
xhr.onload = function() {
  console.log('Signed in as: ' + xhr.responseText);
};
xhr.send('idtoken=' + id_token);
  
  
  
  
  
}

    
    function signOut() {
    var auth2 = gapi.auth2.getAuthInstance();
    auth2.signOut().then(function () {
      console.log('User signed out.');
    });
  }

  
  
  
  $(document).ready(function () {


});