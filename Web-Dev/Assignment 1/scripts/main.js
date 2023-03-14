var containerHidden = false;
var frameHidden = true;

window.onload = load_it();

function menu() {
    var x = document.getElementById("navmenu");
    if (x.className === "sidenav") {
        x.className += " responsive";
    } else {
        x.className = "sidenav";
    }
}

function linkclick(url) {
    if (containerHidden) {
        frameHidden = true;
        containerHidden = false;
        document.getElementById('pageframe').style.visibility = "hidden";
        document.getElementById('pageframe').style.width = "0px";
        document.getElementById('pageframe').style.height = "0px";
        document.getElementById('container').style.display = "block";
        document.getElementById('container').style.height = "70%";
        document.getElementById('container').style.width = "75%";
        document.getElementById('container').style.border = "none";
        document.getElementById('container').style.margin = "2.5% 0% 0% 10%";
        jQuery(document).ready(function ($) {
            $("#container").load(url);
        });
    } else if (!containerHidden) {
        jQuery(document).ready(function ($) {
            $("#container").load(url);
        });
    }
}

function framerender(url) {
    if (frameHidden) {
        frameHidden = false;
        containerHidden = true;
        document.getElementById('container').style.width = "0px";
        document.getElementById('container').style.height = "0px";
        document.getElementById('container').style.display = "none";
        document.getElementById('pageframe').style.visibility = "visible";
        document.getElementById('pageframe').style.width = "75%";
        document.getElementById('pageframe').style.height = "700px";
        document.getElementById('pageframe').style.margin = "0% 0% 0% 10%";
        document.getElementById('pageframe').style.border = "none";
        document.getElementById('pageframe').src = url;
    } else {
         document.getElementById('pageframe').src = url;
    }
}


function load_it() {
    document.getElementById('pageframe').style.visibility = "hidden";
    document.getElementById('pageframe').style.height = "0px";
    document.getElementById('pageframe').style.width = "0px";
    jQuery(document).ready(function ($) {
        $("#container").load("home.html");
    });
}
