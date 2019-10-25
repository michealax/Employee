<template>
    <div>
        <el-button :plain="true" @click="open">Show message</el-button>
        <el-button @click="logout">log out</el-button>
    </div>
</template>
<script>
    export default {
        name: 'HelloWorld',
        props: {
            msg: String
        },
        data() {
            return {
                show: true
            }
        },
        methods: {

            logout() {
                sessionStorage.removeItem("loginInfo");
                this.$router.push("/")
            },
            open() {
                this.$message('This is a message.');
            }
        }
    }
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
    .transition-box {
        margin-bottom: 10px;
        width: 200px;
        height: 100px;
        border-radius: 4px;
        background-color: #409EFF;
        text-align: center;
        color: #fff;
        padding: 40px 20px;
        box-sizing: border-box;
        margin-right: 20px;
    }
</style>
