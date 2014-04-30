<link rel="stylesheet" href="sceditor/minified/themes/default.min.css" type="text/css" media="all" />
<link rel="stylesheet" href="css/highlight.css" type="text/css" />

<script src="sceditor/minified/jquery.sceditor.bbcode.min.js"></script>

<style>            
    .sceditor textarea {
        width: 120%;
        height: 416px;
        font-family: Courier New;
    }
</style>

<div class="sceditor">
    <textarea name="articleContent" placeholder="Type content here"></textarea>
</div>

<script>

    var sceditor;

    $(document).ready(function() {
        var initEditor = function() {
            
            sceditor = $(".sceditor textarea");
            
            sceditor.sceditor({
                plugins: 'xhtml',
                style: "sceditor/minified/jquery.sceditor.default.min.css"
            });
            
            var sceditorInstance = sceditor.sceditor('instance');
            
            sceditor.getValue = function() {
                return sceditorInstance.val();
            };
        };
        
        initEditor();
    });
</script>