
angular.module('workix').controller('NewCommentController', function ($scope, $location, locationParser, flash, CommentResource , BlogResource) {
    $scope.disabled = false;
    $scope.$location = $location;
    $scope.comment = $scope.comment || {};
    
    $scope.blogList = BlogResource.queryAll(function(items){
        $scope.blogSelectionList = $.map(items, function(item) {
            return ( {
                value : item.id,
                text : item.blogCategory
            });
        });
    });
    $scope.$watch("blogSelection", function(selection) {
        if ( typeof selection != 'undefined') {
            $scope.comment.blog = {};
            $scope.comment.blog.id = selection.value;
        }
    });
    

    $scope.save = function() {
        var successCallback = function(data,responseHeaders){
            var id = locationParser(responseHeaders);
            flash.setMessage({'type':'success','text':'The comment was created successfully.'});
            $location.path('/Comments');
        };
        var errorCallback = function(response) {
            if(response && response.data) {
                flash.setMessage({'type': 'error', 'text': response.data.message || response.data}, true);
            } else {
                flash.setMessage({'type': 'error', 'text': 'Something broke. Retry, or cancel and start afresh.'}, true);
            }
        };
        CommentResource.save($scope.comment, successCallback, errorCallback);
    };
    
    $scope.cancel = function() {
        $location.path("/Comments");
    };
});