app.run(['$route', '$rootScope', '$location', function ($route, $rootScope, $location) {
    var original = $location.path;
    $location.path = function (path, reload) {
    	console.log(original);
        if (reload === false) {
            var lastRoute = $route.current;
            var un = $rootScope.$on('$locationChangeSuccess', function () {
            	console.log("dfdfdf");
                $route.current = lastRoute;
                un();
            });
        }
        console.log(original);
        console.log(path);
        console.log(reload);
        return original.apply($location, [path]);
    };
}])