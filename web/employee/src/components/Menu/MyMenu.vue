<template>
    <el-menu
            :default-active="activeIndex"
            class="el-menu-demo"
            mode="horizontal"
            background-color="#545c64"
            text-color="#fff"
            active-text-color="#ffd04b">
        <el-menu-item index="1" @click="goTo('jobs')">首页</el-menu-item>
        <el-submenu index="2" @click="goTo('profile')">
            <template slot="title">我的</template>
            <el-menu-item index="2-1" @click="goTo('profile')">
                <el-icon class="el-icon-user"></el-icon>
                <span>个人中心</span>
            </el-menu-item>
            <el-menu-item index="2-2" @click="logout">
                <el-icon class="el-icon-switch-button"></el-icon>
                <span>退出</span>
            </el-menu-item>
            <el-menu-item index="2-3">
                <el-icon class="el-icon-info"></el-icon>
                <span>关于</span>
            </el-menu-item>
        </el-submenu>
    </el-menu>
</template>

<script>
    export default {
        name: "MyMenu",
        props:{
            activeIndex:{
                type: String,
                default:''
            }
        },
        methods:{
            goTo(url) {
                console.log(this.$route.name + " " + url);
                if (url && url !== this.$route.name) {
                    this.$router.push(url)
                }
            },
            logout() {
                sessionStorage.removeItem("loginInfo");
                this.$router.push("/")
            },
        }
    }
</script>

<style scoped>

</style>
