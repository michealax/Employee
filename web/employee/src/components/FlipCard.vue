<template>
    <div v-bind:class="flipped ? 'flip-container flipped': 'flip-container'">
        <div class="flipper">
            <div class="front">
                <slot name="front"></slot>
                <i class="frontFlipBtn el-icon-edit"
                   v-on:click="changeState(true)">
                </i>
            </div>
            <div class="back">
                <slot name="back"></slot>
                <!--<i class="backFlipBtn el-icon-back"-->
                   <!--v-on:click="changeState(false)">-->
                <!--</i>-->
            </div>
        </div>
    </div>

</template>

<script>
    export default {
        name: 'FlipCard',
        data: function () {
            return {
                flipped: false
            };
        },
        methods: {
            changeState(state) {
                this.flipped = state;
            }
        }
    };
</script>

<style lang="scss">
    i.frontFlipBtn,
    i.backFlipBtn {
        position: absolute;
        right: 10px;
        top: 10px;
        color: black;
    }

    i.backFlipBtn {
        -webkit-transform: rotateY(-180deg);
        -moz-transform: rotateY(-180deg);
        -o-transform: rotateY(-180deg);
        -ms-transform: rotateY(-180deg);
        transform: rotateY(-180deg);
    }

    .flip-container {
        -webkit-perspective: 500px;
        -moz-perspective: 500px;
        -o-perspective: 500;
        perspective: 500px;
    }

    .flip-container {
        width: 500px;
        margin: 0 auto;
    }

    .flipper {
        -moz-transform: perspective(500px);
        -moz-transform-style: preserve-3d;
        position: relative;
    }

    .front,
    .back {
        -webkit-backface-visibility: hidden;
        -moz-backface-visibility: hidden;
        -o-backface-visibility: hidden;
        backface-visibility: hidden;
        -webkit-transition: 0.6s;
        -webkit-transform-style: preserve-3d;
        -moz-transition: 0.6s;
        -moz-transform-style: preserve-3d;
        -o-transition: 0.6s;
        -o-transform-style: preserve-3d;
        -ms-transition: 0.6s;
        -ms-transform-style: preserve-3d;
        transition: 0.6s;
        transform-style: preserve-3d;
        top: 0;
        left: 0;
        width: 100%;
    }

    .back {
        -webkit-transform: rotateY(-180deg);
        -moz-transform: rotateY(-180deg);
        -o-transform: rotateY(-180deg);
        -ms-transform: rotateY(-180deg);
        transform: rotateY(-180deg);
        position: absolute;
    }

    .flip-container.flipped .back {
        -webkit-transform: rotateY(0deg);
        -moz-transform: rotateY(0deg);
        -o-transform: rotateY(0deg);
        -ms-transform: rotateY(0deg);
        transform: rotateY(0deg);
    }

    .flip-container.flipped .front {
        -webkit-transform: rotateY(180deg);
        -moz-transform: rotateY(180deg);
        -o-transform: rotateY(180deg);
        -ms-transform: rotateY(180deg);
        transform: rotateY(180deg);
    }

    .front {
        z-index: 2;
    }
</style>
