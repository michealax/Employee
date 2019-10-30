<template>
    <div class="login-container">
        <el-form ref="registerForm" :model="registerForm" :rules="loginRules" class="login-form" autocomplete="on"
                 label-position="left">

            <div class="title-container">
                <h3 class="title">注册</h3>
            </div>

            <el-form-item>
                <el-icon class="el-icon el-icon-s-promotion"></el-icon>
                <el-select v-model="value" placeholder="账户类型">
                    <el-option
                            v-for="item in options"
                            :key="item.value"
                            :label="item.label"
                            :value="item.value">
                    </el-option>
                </el-select>
            </el-form-item>

            <el-form-item prop="username">
                <el-icon class="el-icon el-icon-user"></el-icon>
                <el-input
                        ref="username"
                        v-model="registerForm.username"
                        placeholder="Username"
                        name="username"
                        type="text"
                        tabindex="1"
                        autocomplete="on"
                />

            </el-form-item>


            <el-form-item prop="password">
                <el-icon class="el-icon el-icon-lock"></el-icon>
                <el-input
                        :key="passwordType"
                        ref="password"
                        v-model="registerForm.password"
                        :type="passwordType"
                        placeholder="Password"
                        name="password"
                        tabindex="2"
                        autocomplete="on"
                        @keyup.native="checkCapslock"
                        @blur="capsTooltip = false"
                />

            </el-form-item>
            <el-form-item prop="password confirm">
                <el-icon class="el-icon el-icon-lock"></el-icon>
                <el-input
                        :key="passwordType"
                        ref="newPassword"
                        v-model="registerForm.newPassword"
                        :type="passwordType"
                        placeholder="Password confirm"
                        name="newPassword"
                        tabindex="3"
                        autocomplete="on"
                        @keyup.native="checkCapslock"
                        @blur="capsTooltip = false"
                />

                <div v-if="this.registerForm.password !== this.registerForm.newPassword" style="color: #f56c6c" class="el-form-item__error">密码不一致</div>
            </el-form-item>


            <el-form-item>
                <el-button :loading="loading" class="el-button--primary" style="width:100%;text-align: center"
                           @click="handleRegister">确定
                </el-button>
            </el-form-item>
            <el-link :loading="loading"  @click="$router.push('login')" style="color: blue">登录</el-link>
        </el-form>
    </div>

</template>

<script>
    import {validEmail} from '../utils/validate'

    export default {
        name: "Login",
        comments: {},
        data() {
            const validateUsername = (rule, value, callback) => {
                if (!validEmail(value)) {
                    callback(new Error('Please enter the correct user name'))
                } else {
                    callback()
                }
            };
            const validatePassword = (rule, value, callback) => {
                if (value.length < 6) {
                    callback(new Error('The password can not be less than 6 digits'))
                } else {
                    callback()
                }
            };

            return {
                registerForm: {
                    username: '',
                    password: '',
                    newPassword: ''
                },
                loginRules: {
                    username: [{required: true, trigger: 'blur', validator: validateUsername}],
                    password: [{required: true, trigger: 'blur', validator: validatePassword}],
                    newPassword: [{required: true, trigger: 'blur', validator: validatePassword}]
                },
                passwordType: 'password',
                capsTooltip: false,
                loading: false,
                showDialog: false,
                redirect: undefined,
                otherQuery: {},
                options: [{
                    value: 0,
                    label: '个人'
                }, {
                    value: 1,
                    label: '企业'
                }],
                value: 0
            }
        },
        watch: {
            $route: {
                handler: function (route) {
                    const query = route.query
                    if (query) {
                        this.redirect = query.redirect
                        this.otherQuery = this.getOtherQuery(query)
                    }
                },
                immediate: true
            }
        },
        created() {
            // window.addEventListener('storage', this.afterQRScan)
        },
        mounted() {
            if (this.registerForm.username === '') {
                this.$refs.username.focus()
            } else if (this.registerForm.password === '') {
                this.$refs.password.focus()
            } else if (this.registerForm.newPassword === ''){
                this.$refs.newPassword.focus()
            }
        },
        destroyed() {
            // window.removeEventListener('storage', this.afterQRScan)
        },
        methods: {
            checkCapslock({shiftKey, key} = {}) {
                if (key && key.length === 1) {
                    if (shiftKey && (key >= 'a' && key <= 'z') || !shiftKey && (key >= 'A' && key <= 'Z')) {
                        this.capsTooltip = true
                    } else {
                        this.capsTooltip = false
                    }
                }
                if (key === 'CapsLock' && this.capsTooltip === true) {
                    this.capsTooltip = false
                }
            },
            showPwd() {
                if (this.passwordType === 'password') {
                    this.passwordType = ''
                } else {
                    this.passwordType = 'password'
                }
                this.$nextTick(() => {
                    this.$refs.password.focus()
                })
            },
            checkType() {
                return (this.value === 0 || this.value === 1);
            },
            getOtherQuery(query) {
                return Object.keys(query).reduce((acc, cur) => {
                    if (cur !== 'redirect') {
                        acc[cur] = query[cur]
                    }
                    return acc
                }, {})
            },
            // afterQRScan() {
            //   if (e.key === 'x-admin-oauth-code') {
            //     const code = getQueryObject(e.newValue)
            //     const codeMap = {
            //       wechat: 'code',
            //       tencent: 'code'
            //     }
            //     const type = codeMap[this.auth_type]
            //     const codeName = code[type]
            //     if (codeName) {
            //       this.$store.dispatch('LoginByThirdparty', codeName).then(() => {
            //         this.$router.push({ path: this.redirect || '/' })
            //       })
            //     } else {
            //       alert('第三方登录失败')
            //     }
            //   }
            // },
            handleRegister() {
                this.$refs.registerForm.validate(valid => {
                    if (valid && this.checkType() && this.registerForm.password === this.registerForm.newPassword) {
                        sessionStorage.setItem("loginInfo", '123');
                        this.$router.push("/profile")
                    } else {
                        console.log('error submit!!')
                        return false
                    }
                })
            }
        }
    }
</script>
<style lang="scss">
    /* 修复input 背景不协调 和光标变色 */
    /* Detail see https://github.com/PanJiaChen/vue-element-admin/pull/927 */
    $bg: #2d3a4b;
    $light_gray: #fff;
    $cursor: #fff;
    @supports (-webkit-mask: none) and (not (cater-color: $cursor)) {
        .login-container .el-input input {
            color: $cursor;
        }
    }

    /* reset element-ui css */
    .login-container {
        .el-input {
            display: inline-block;
            height: 47px;
            width: 200px;
            min-width: 200px;

            input {
                background: transparent;
                border: 0px;
                -webkit-appearance: none;
                border-radius: 0px;
                padding: 16px 5px 16px 15px;
                color: $light_gray;
                height: 47px;
                caret-color: $cursor;

                &:-webkit-autofill {
                    box-shadow: 0 0 0px 1000px $bg inset !important;
                    -webkit-text-fill-color: $cursor !important;
                }
            }
        }

        .el-form-item {
            border: 1px solid rgba(255, 255, 255, 0.1);
            background: rgba(0, 0, 0, 0.1);
            border-radius: 5px;
            color: #454545;
            width: 320px;
            margin: 16px auto;

            .el-icon {
                color: white;
            }
        }


    }
</style>
<style scoped lang="scss">
    $bg: #2d3a4b;
    $dark_gray: #889aa4;
    $light_gray: #eee;
    .login-container {

        height: 100%;
        width: 85%;
        background-color: $bg;
        min-width: 300px;
        overflow: hidden;

        .login-form {

            position: relative;
            width: 520px;
            max-width: 100%;
            padding: 160px 35px 0;
            margin: 0 auto;

            overflow: hidden;
        }

        .tips {
            font-size: 14px;
            color: #fff;
            margin-bottom: 10px;

            span {

                &:first-of-type {
                    margin-right: 16px;
                }
            }

        }

        .title-container {

            position: relative;


            .title {
                font-size: 26px;
                color: $light_gray;
                margin: 0px auto 40px auto;

                text-align: center;

                font-weight: bold;

            }
        }

        .show-pwd {
            font-size: 16px;
            color: $dark_gray;

            cursor: pointer;

            user-select: none;

        }

        .thirdparty-button {

            position: absolute;
            right: 0;
            bottom: 6px;

        }

        @media only screen and (max-width: 470px) {
            .thirdparty-button {

                display: none;

            }
        }
    }

</style>
