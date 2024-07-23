const { defineConfig } = require('@vue/cli-service')
module.exports = defineConfig({
  transpileDependencies: true,
  devServer: {
    port: 3000, // 원하는 포트 번호로 변경합니다.
    proxy: {
      '/api': {
        target: 'http://ec2-52-78-114-159.ap-northeast-2.compute.amazonaws.com',
      },
    }
  }
})
