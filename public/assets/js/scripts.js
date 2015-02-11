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
					var html = "<a class='btn btn-primary btn-xs btn-temporada' href='#serie-" + serie.id + "-t-" + (i + 1) + "' onclick='$(\".temporada\").hide(); $(\"#serie-" + serie.id + "-t-" + (i + 1) + "\").toggle(500);' title='Ver episódios da temporada " + (i + 1) + "'>" + (i + 1) + "</a> Próximo episódio: <span>" + temporada + "</span><br />"
					$("#temporadas").append(html);
				}
			},
			fail: function(data) {
				console.log(data);
			}
		});
	});
});