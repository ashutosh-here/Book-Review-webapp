 
  $(document).ready(function () {
$('#submit').on('click',function(){
  var rating = $("input[name=rating]:checked").attr('value');
  // var name = $('#alias').val();
  var review = $('#review').val();
  if(rating == '0'){
     $('.error').show();
    $('.error').html('Please select rating');
    
  
  }else if(review == ''){
      $('.error').show();
    $('.error').html('Please enter review');
  }else if(review.length <=2 || review.legth >=250){
      $('.error').show();
     $('.error').html('Please enter review in less than 250 Characters');
  }else{
      $('.error').hide();
    $('.error').html('');       
//    alert(rating+'|'+name+'|'+review);
    $('.rating-form').hide();
    $('.rating-success').addClass('active');
    
    
     console.log("clicked on confirm");

    var form = $(".rating-form");


    $.ajax({
        url: "RatingFeedbackServlet",
        type: 'POST',
        data: form.serialize(),
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
        }


    });
    
    
    
    
  }
})

});