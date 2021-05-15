function test() {
//Get the modal
var modal = document.getElementById("myModal");

// Get the button that opens the modal
var btn = document.getElementById("myBtn");

// Get the <span> classname that closes the the modal
var span = document.getElementsByClassName("close");

// When the user clicks the button, open the modal
btn.onclick = function() { modal.style.display = "block"; }

//When the user clicks on <span> (x), close the modal
span.onclick = function() { modal.style.display = "none"; }

//When the user clicks anywhere outside of the modal, close it
window.click = function(event) {
    if (event.target == modal) {
        modal.style.display = "none";
    }
}
}