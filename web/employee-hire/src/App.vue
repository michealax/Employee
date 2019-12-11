<template>
    <div id="app">
        <router-view></router-view>
    </div>
</template>

<script>


    export default {
        name: 'app',
        components: {

        }
    }
</script>

<style>
    body{
        background: #2d3a4b;;
    }
    #app {
        font-family: 'Avenir', Helvetica, Arial, sans-serif;
        -webkit-font-smoothing: antialiased;
        -moz-osx-font-smoothing: grayscale;
        text-align: center;
        color: #2d3a4b;
        margin-top: 60px;
    }
</style>
