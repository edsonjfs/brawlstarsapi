const path = require('path');
const VueLoaderPlugin = require('vue-loader/lib/plugin')
const HtmlWebpackPlugin = require('html-webpack-plugin');
const { resolve } = require('path');

module.exports = {
  mode: 'development',
  entry: {
      home: resolve('src/main.js'),
      clubs: resolve('src/clubs.js'),
      front: resolve('src/front.js'),
  },
  output: {
    filename: 'js/[name].[hash].bundle.js',
    path: path.resolve(__dirname, '../resources/META-INF/resources')
  },
  module: {
    rules: [
        { test: /\.vue$/, use: 'vue-loader' },
        { test: /\.js$/, exclude: /node_modules/, use: ['babel-loader'] },
        { test: /\.css$/, use: [ 'vue-style-loader', 'css-loader' ]}
    ],
  },
  plugins: [
    new VueLoaderPlugin(),
    new HtmlWebpackPlugin({
        template: 'src/view/home.html',
        chunks: ['home'],
        filename: path.resolve(__dirname, '../resources/META-INF/resources/index.html'),
    }),
    new HtmlWebpackPlugin({
      template: 'src/view/clubs.html',
      chunks: ['clubs'],
      filename: path.resolve(__dirname, '../resources/META-INF/resources/clubs.html'),
  }),
  new HtmlWebpackPlugin({
    template: 'src/view/front.html',
    chunks: ['front'],
    filename: path.resolve(__dirname, '../resources/META-INF/resources/front.html'),
}),
  ]
};