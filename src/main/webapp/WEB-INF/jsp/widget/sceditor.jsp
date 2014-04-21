<link rel="stylesheet" href="sceditor/minified/themes/default.min.css" type="text/css" media="all" />

<script src="jquery/jquery.min.js"></script>
<script src="sceditor/minified/jquery.sceditor.bbcode.min.js"></script>

<style>            
    .sceditor textarea {
        width: 804px;
        height: 400px;
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
                style: "sceditor/minified/jquery.sceditor.modern.min.css"
            });
            
            var sceditorInstance = sceditor.sceditor('instance');
            
            sceditor.getValue = function() {
                return sceditorInstance.val();
            };
        };
        
        initEditor();
    });
</script>