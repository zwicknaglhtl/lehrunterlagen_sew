// More info about initialization & config:
// - https://revealjs.com/initialization/
// - https://revealjs.com/config/


if (window.location.search.includes("master")) { 

	console.log("master slides");

	Reveal.initialize({
		hash: true,
		pdfSeparateFragments: false,
		// Learn about plugins: https://revealjs.com/plugins/
		plugins: [RevealMarkdown, RevealHighlight, RevealNotes, RevealSearch
			//{ src: '../../../../node_modules/reveal.js-d3js/d3js.js' } //https://github.com/jlegewie/reveal.js-d3js-plugin (nocht nicht verwendet)
		],
		multiplex: {
			// Example values. To generate your own, see the socket.io server instructions.
			secret: '16317776364815398329', // Obtained from the socket.io server. Gives this (the master) control of the presentation
			id: 'a5d866bdea78fab0', // Obtained from socket.io server
			url: 'https://multiplex-htl.glitch.me/' // Location of socket.io server
		  },
			// Don't forget to add the dependencies
		dependencies: [
				{ src: '//cdnjs.cloudflare.com/ajax/libs/socket.io/2.2.0/socket.io.js', async: true },
				{ src: 'https://multiplex-htl.glitch.me/master.js', async: true },
			
				// and if you want speaker notes
				//{ src: '../../../../../node_modules/reveal-notes-server/client.js', async: true }
			  ]
	});


} else {
	console.log("client slide");

	Reveal.initialize({
		hash: true,
		pdfSeparateFragments: false,
		// Learn about plugins: https://revealjs.com/plugins/
		plugins: [RevealMarkdown, RevealHighlight, RevealNotes, RevealSearch
			//{ src: '../../../../node_modules/reveal.js-d3js/d3js.js' } //https://github.com/jlegewie/reveal.js-d3js-plugin (nocht nicht verwendet)
		],
		multiplex: {
			// Example values. To generate your own, see the socket.io server instructions.
			secret: '', // Obtained from the socket.io server. Gives this (the master) control of the presentation
			id: 'a5d866bdea78fab0', // Obtained from socket.io server
			url: 'https://multiplex-htl.glitch.me/' // Location of socket.io server
		  },
			// Don't forget to add the dependencies
		dependencies: [
				{ src: '//cdnjs.cloudflare.com/ajax/libs/socket.io/2.2.0/socket.io.js', async: true },
		
				{ src: 'https://multiplex-htl.glitch.me/client.js', async: true }
			  ]
	});
	

}






//verwende für Graphen draw.io
//für Graphen - Graphviz: https://github.com/magjac/d3-graphviz
//http://magjac.com/graphviz-visual-editor/ (funktioniert nur in Chrome	)
//https://edotor.net/
//Tutorials: https://sketchviz.com/graphviz-examples
//https://sketchviz.com/flowcharts-in-graphviz

