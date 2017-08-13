var app = angular.module('myApp', []);


app.controller('mainController', function ($scope, restService) {
    $scope.employees = [];
    restService.findEmployee().then(function (resp) {
        $scope.employees = resp.data
    });
    $scope.empupdate = function (employee) {
        $scope.employeeupdate = {
            'id': employee.id,
            'name': employee.name,
            'age': employee.age,
            'position': employee.position,
            'salary': employee.salary
        }
    }
    $scope.employeeUpdate = function (employee) {
        restService.updateEmployee(employee).then(function (response) {
            restService.findEmployee().then(function (resp) {
                $scope.employees = resp;
            });
        });
    }
    $scope.submitEmp = function (employee) {
        var data = {
            'name': employee.name,
            'age': employee.age,
            'position': employee.position,
            'salary': employee.salary
        };

        restService.createEmployee(data).then(function (response) {
            restService.findEmployee().then(function (resp) {
                $scope.employees = resp;
                $scope.employee = "";
            });
        });
    };
    
    $scope.deleteEmp = function(id){
        restService.deleteEmployee(id).then(function (response) {
            restService.findEmployee().then(function (resp) {
                $scope.employees = resp;
            });
        });
    }
});

app.factory('restService', function ($http) {
    var myService = {
        createEmployee: function (data) {
            var promise = $http.post('/createEmployee', data).then(function (response) {
                return response.data;
            });
            return promise;
        },
        updateEmployee: function (data) {
            var promise = $http.put('/updateEmployee', data).then(function (response) {
                return response.data;
            });
            return promise;
        },
        findEmployee: function () {
            var promise = $http.get('/getEmployee').then(function (response) {
                return response.data;
            });
            return promise;
        },
        deleteEmployee: function (id) {
            var promise = $http.delete('/deleteEmployee/'+id).then(function (response) {
                return response;
            });
            return promise;
        }
    }
    return myService;
});