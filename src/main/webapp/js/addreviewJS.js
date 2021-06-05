
// fun to render form inputs on modal
function my() {

    var x = document.getElementById('Aname').value;//store form values on variabale

    var y = document.getElementById('Bname').value;//store form values on variabale

    var z = document.getElementById('Bintro').value;
    var u = document.getElementById('Bfav').value;
    var v = document.getElementById('Baud').value;


    // to render form values on respective modal screens 
    $("#An").html(x);

    $("#Bn").html(y);


    $("#Bi").html(z);
    $("#Bf").html(u);
    $("#Ba").html(v);




}



// fun to show image

function showMyImage(fileInput) {
    var files = fileInput.files;
    for (var i = 0; i < files.length; i++) {
        var file = files[i];
        var imageType = /image.*/;
        if (!file.type.match(imageType)) {
            continue;
        }
        var img = document.getElementById("thumbnil");
        img.file = file;
        var reader = new FileReader();
        reader.onload = (function (aImg) {
            return function (e) {
                aImg.src = e.target.result;
            };
        })(img);
        reader.readAsDataURL(file);
    }
}


// function to send form data to server
function send() {
    console.log("clicked on confirm");

    var form = $("#AddreviewForm")[0];

    var Fdata = new FormData(form);
    console.log(Fdata);

    $.ajax({
        url: "AddReviewServlet",
        type: 'POST',
        data: Fdata,
        success: function (data, textStatus, jqXHR) {


            console.log(data);
            if (data.trim() == 'sucess')
            {
                  
                swal("Done!", "Succesfully updated", "success");
               //  location.reload();
     } else
            {
                swal("Error!!", "Something went wrong try again...", "error");
            }


        },

        error: function (jqXHR, textStatus, errorThrown) {
            //error..
            swal("Error!!", "Something went wrong try again...", "error");
        },
        processData: false,
        contentType: false


    });
}