$(document).ready(function() {
	$(".recomendacao").click(function(){
		$.ajax({
			type: 'POST',
			url: 'serie/recomendacao',
			data: $(this).parent().parent().serialize(),
			success: function(data) {
                   serie = JSON.parse(data);
                   console.log(serie);
                   $("#temporadas").html("");
                   for (var i = 0; i < serie.temporadas.length; i++) {
                           var temporada = serie.temporadas[i];
                           var html = "<a class='btn btn-primary btn-xs btn-temporada' href='#serie-" + serie.id + "t-" + temporada.temporada + "' onclick='$(\".temporada\").hide(); $(\"#serie-" + serie.id + "t" + temporada.temporada + "\").toggle(500);' title='Ver episódios da temporada " + temporada.temporada + "'>" + temporada.temporada + "</a> Próximo episódio: <span>" + temporada.nome + "</span><br />"
                           $("#temporadas").append(html);
                   }
          	},
			fail: function(data) {
				console.log(data);
			}
		});
	});
});