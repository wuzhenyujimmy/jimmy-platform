<link rel="stylesheet" href="sceditor/minified/themes/default.min.css" type="text/css" media="all" />

<script src="jquery/jquery.min.js"></script>
<script src="sceditor/minified/jquery.sceditor.bbcode.min.js"></script>

<style>			
	.sceditor textarea {
		width: 800px;
		height: 400px;
	}
</style>

<script>
    $(document).ready(function() {
    	var initEditor = function() {
            $(".sceditor textarea").sceditor({
                plugins: 'bbcode',
                style: "sceditor/minified/jquery.sceditor.default.min.css"
            });
        };
        initEditor();
    });
</script>

<div class="sceditor">
    <textarea name="bbcode_field"></textarea>
</div>