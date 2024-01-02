<template>
  <v-app>
    <v-navigation-drawer app>
      <v-list>
        <v-list-item to="/" title="Rider Management" link>
          <v-list-item-content>
            <v-list-item-title>Rider Management</v-list-item-title>
          </v-list-item-content>
        </v-list-item>
        <!-- Additional navigation items can be added here -->
      </v-list>
    </v-navigation-drawer>
    <v-app-bar app>
      <v-app-bar-nav-icon @click.stop="drawer = !drawer"></v-app-bar-nav-icon>
      <v-toolbar-title>Rider Management System</v-toolbar-title>
    </v-app-bar>
    <v-main>
      <router-view></router-view>
    </v-main>
  </v-app>
</template>

<script>
export default {
  name: 'App',
  data: () => ({
    drawer: null,
  }),
};
</script>