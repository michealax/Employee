<template>
    <div>
        <my-menu :active-index="'1'"></my-menu>
    </div>
</template>

<script>
    import MyMenu from "../components/Menu/MyMenu";
    export default {
        name: "Home",
        components: {MyMenu}
    }
</script>

<style scoped>

</style>
