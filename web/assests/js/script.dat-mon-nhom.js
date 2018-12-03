$("#btn-copy-link").click(() => {
    $("#txt-link").select();
    document.execCommand("copy");
});