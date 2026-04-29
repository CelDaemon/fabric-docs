<script setup lang="ts">
import {ref, useId} from 'vue';

const outputId = useId();

function generate() {
  const array = new Uint32Array(1);
  crypto.getRandomValues(array);
  const generated = array[0];
  return generated.toString(16).toUpperCase();
}

const seed = ref(generate());

function regenerate() {
  seed.value = generate();
}

function copy() {
  navigator.clipboard.writeText(seed.value);
}
</script>

<template>
  <div class="container">
    <label :for="outputId">
      Seed:
    </label>
    <output :id="outputId" tabindex="0">
      0x{{ seed }}
    </output>
    <button @click="regenerate">Regenerate</button>
    <button @click="copy">Copy</button>
  </div>
</template>

<style scoped>
.container {
  background: var(--docsearch-modal-background);
}
</style>
