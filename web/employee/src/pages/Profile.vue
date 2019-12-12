<template>
    <div class="app-container">
        <my-menu :active-index="'2-1'"></my-menu>
        <div v-if="user">
            <el-row :gutter="20">
                <el-col :span="6" :xs="24">
                    <user-card :user="user"/>
                </el-col>

                <el-col :span="18" :xs="24">
                    <el-card style="width: 100%">
                        <el-tabs v-model="activeTab">
                            <el-tab-pane label="简历" name="activity">
                                <activity/>
                            </el-tab-pane>
                            <el-tab-pane label="Timeline" name="timeline">
                                <timeline/>
                            </el-tab-pane>
                            <el-tab-pane label="账号" name="account">
                                <account :user="user"/>
                            </el-tab-pane>
                        </el-tabs>
                    </el-card>
                </el-col>

            </el-row>
        </div>
    </div>
</template>

<script>
    // import {mapGetters} from 'vuex'
    import UserCard from '../components/profile/UserCard'
    import Activity from '../components/profile/Activity'
    import Timeline from '../components/profile/Timeline'
    import Account from '../components/profile/Account'
    import MyMenu from "../components/Menu/MyMenu";

    export default {
        name: 'Profile',
        components: {MyMenu, UserCard, Activity, Timeline, Account},
        data() {
            return {
                user: {
                    id: 1,
                    username: '123@163.com'
                },
                activeTab: 'activity',
                activeIndex: '2-1',
            }
        },
        computed: {
            // ...mapGetters([
            //     'name',
            //     'avatar',
            //     'roles'
            // ])
        },
        created() {
            this.getUser()
        },
        methods: {

            getUser() {
                this.user = {
                    id: 1,
                    username: 'shane@163.com'
                }
            }

        }
    }
</script>
<style lang="scss">
    .el-menu-vertical-demo:not(.el-menu--collapse) {
        width: 200px;
        min-height: 400px;
    }
</style>
