const fs = require('fs');
for (const a of fs.readdirSync('../../textures/items').map((s) => s.substring(0, s.length - 4))) {
  fs.writeFileSync(a + '.json', JSON.stringify({
    parent: 'item/handheld',
    textures: {
      layer0: 'brethit:items/' + a
    }
  }, null, '  '));
}