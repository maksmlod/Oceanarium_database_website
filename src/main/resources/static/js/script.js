function successfullyLogout(){
alert("You have been successfully logged out");
}

/* Set the width of the side navigation to 250px */
function openNav() {
  document.getElementById("mySidenav").style.width = "250px";
}

/* Set the width of the side navigation to 0 */
function closeNav() {
  document.getElementById("mySidenav").style.width = "0";
}

$(document).on("hide.bs.dropdown", ".dropdown", function (event) {
    $(event.target).find(">.dropdown-menu:first").slideUp();
});

$(document).on("show.bs.dropdown", ".dropdown", function (event) {
    $(event.target).find(">.dropdown-menu:first").slideDown();
});