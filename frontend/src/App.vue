<template>
  <div>
    <!-- <nav>
      <RouterLink to="/">Home</RouterLink>
      <RouterLink to="/main">Main</RouterLink> 
      <RouterLink to="/categories">Categories</RouterLink>
      <RouterLink to="/places">Places</RouterLink>
      <<RouterLink to="/new-place">New Place</RouterLink>
      <RouterLink to="/mypage">My Page</RouterLink>
    </nav> -->

    <RouterView />
  </div>
</template>

<script>
export default {
  name: "App",
};
</script>

<style>
nav {
  display: flex;
  gap: 10px;
  margin-bottom: 20px;
}
</style>
