const TerserPlugin = require('terser-webpack-plugin');

config.optimization = {
    ...config.optimization,
    minimize: true,
    minimizer: [
        new TerserPlugin({
            terserOptions: {
                // mangle: false,  // Uncomment to disable name mangling
                compress: {
                    passes: 2,  // webpack's default
                },
            }
        })
    ]
}