<script setup>
import {
  VerticalNavLink,
  VerticalNavSectionTitle,
} from '@layouts'
</script>

<template>
    <ul>
        <VerticalNavSectionTitle :item="{ heading: 'Organization' }" />
        <VerticalNavLink
            :item="{
                title: '팀',
                to: '/teams',
            }"
        />
        <VerticalNavSectionTitle :item="{ heading: 'Test' }" />
        <VerticalNavLink
            :item="{
                title: 'Test',
                to: '/tests',
            }"
        />
    </ul>
</template>
