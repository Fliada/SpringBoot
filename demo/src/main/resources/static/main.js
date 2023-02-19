window.onload = function () {
    $(".like").click((e) => {
        alert("debug: button text: " + e.currentTarget.innerText);
    });
};