
<style>
    header {
    
    }
    
    header .upper {
        height: 75px;
    }
    
    header .upper > div {
        float: left;
    }
    
    header .upper .logo {
        height: 75px;
        width: 320px;
        background-image: url("images/logo.png");
        margin-left: 50px;
    }
    
    header .upper .search-box {
        height: 75px;
        width: 520px;
        position: relative;
        padding-top: 16px;
        margin-left: 50px;
    }
    
    header .upper .search-box .ico-search {
        display: block;
        position: absolute;
        top: 33px;
        left: 11px;
        width: 14px;
        height: 14px;
        background: url(images/sprite_search.png) 0 -206px repeat-x;
        overflow: hidden;
    }
    
    header .upper .search-box .search-input {
        float: left;
        width: 432px;
        height: 46px;
        padding-left: 34px;
        padding-right: 10px;
        border: 1px solid #cecece;
        border-right: none;
        outline: 0;
        font-size: 14px;
        background: #fafafa url(images/sprite_search.png) 0 -54px repeat-x;
        -webkit-transition: all .2s ease;
        -moz-transition: all .2s ease;
        transition: all .2s ease;
    }
    
    header .upper .search-box .search-btn {
        display: block;
        width: 85px;
        height: 46px;
        background: #ff5d00 url(images/sprite_search.png) 0 -108px no-repeat;
        border: none;
        outline: 0;
        zoom: 1;
        cursor: pointer;
    }
    
    header .nav {
        width: 100%;
        height: 45px;
        padding-top: 3px;
        box-shadow: 0 2px 6px rgba(0,0,0,.4);
        overflow: hidden;
        background-color: rgba(256,256,256,.72);
        -webkit-transition: all .2s ease;
        -moz-transition: all .2s ease;
        transition: all .2s ease;
        -webkit-transform: translateZ(0);
    }
    
    header .nav .nav-top {
        position: absolute;
        top: -3px;
        left: 0;
        width: 100%;
        height: 3px;
        line-height: 0;
        font-size: 0;
        overflow: hidden;
        text-align: center;
        z-index: 1;
        background-color: #0fa6ea;
        background: -webkit-linear-gradient(left,rgba(15,166,234,1) 0,rgba(89,204,24,1) 10%,rgba(15,166,234,1) 60%,rgba(15,166,234,1) 100%);
        background: -moz-linear-gradient(left,rgba(15,166,234,1) 0,rgba(89,204,24,1) 10%,rgba(15,166,234,1) 60%,rgba(15,166,234,1) 100%);
        background: -ms-linear-gradient(left,rgba(15,166,234,1) 0,rgba(89,204,24,1) 10%,rgba(15,166,234,1) 60%,rgba(15,166,234,1) 100%);
        background: linear-gradient(left,rgba(15,166,234,1) 0,rgba(89,204,24,1) 10%,rgba(15,166,234,1) 60%,rgba(15,166,234,1) 100%);
    }
    
    header .nav-item {
        float: left;
    }
    
</style>

<header>
    <div class="upper">
        <div class="logo"></div>
        <div class="search-box">
            <i class="ico-search"></i>
            <input type="text" class="search-input" placeholder="Type to search">
            <input class="search-btn" type="button">
        
        </div>
        <div class="user-profile"></div>
    </div>

    <div class="nav">
        <div class="nav-top"></div>
        <div class="nav-item">aaaaaaaaaa</div>
        <div class="nav-item">bbbbbbbbbb</div>
        <div class="nav-item">cccccccccc</div>
    </div>
</header>