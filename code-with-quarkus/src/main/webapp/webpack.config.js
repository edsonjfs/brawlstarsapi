const path = require('path');
const VueLoaderPlugin = require('vue-loader/lib/plugin')
const HtmlWebpackPlugin = require('html-webpack-plugin');
const { resolve } = require('path');

module.exports = {
  mode: 'development',
  entry: {
      home: resolve('src/main.js'),
  },
  output: {
    filename: 'js/[name].[hash].bundle.js',
    path: path.resolve(__dirname, '../resources/META-INF/resources')
  },
  module: {
    rules: [
        { test: /\.vue$/, use: 'vue-loader' },
        { test: /\.js$/, exclude: /node_modules/, use: ['babel-loader'] }
    ],
  },
  plugins: [
    new VueLoaderPlugin(),
    new HtmlWebpackPlugin({
        template: 'src/view/home.html',
        chunks: ['home'],
        filename: path.resolve(__dirname, '../resources/META-INF/resources/index.html'),
    }),
  ]
};