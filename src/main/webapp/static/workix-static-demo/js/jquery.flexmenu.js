// Generated by CoffeeScript 1.6.3
/* 
* flexmenu plugin v1.1
* http://iarouse.com/
*
* License info: http://codecanyon.net/licenses
* http://codecanyon.net/item/flexmenu-responsive-offcanvastoggle-navigation/5550510
*/(function(){(function(e,t){"use strict";return e.fn.flexMenu=function(n){return this.each(function(){var r,i,s,o,u,a,f,l,c,h,p,d,v;d=e.extend({breakpoint:767,responsivePattern:"toggle",animationSpeed:250},n);u=e(this);o=u.find("li");f=e(t);v=void 0;r=e("body");u.addClass("flexmenu");i=e(".fm-button");l=function(){var t;u.find("li").each(function(){var t;t=e(this);if(t.has("ul").length)return t.addClass("with-ul").find("ul").hide()});t=u.find(".with-ul");t.append('<span class="navicon"></span>');if(d.responsivePattern==="toggle")return u.addClass("fm-toggle");if(d.responsivePattern==="off-canvas"){u.addClass("fm-offcanvas");return r.wrapInner('<div class="fm-inner" />').wrapInner('<div class="fm-outer" />')}};l();a=e(".flexmenu .navicon");s=e(".fm-inner");c=!1;i.on("click",function(){u=e(".flexmenu.fm-sm");if(u.hasClass("fm-toggle"))return u.slideToggle(d.animationSpeed);if(u.hasClass("fm-offcanvas")){if(c){s.animate({left:0},{duration:d.animationSpeed});u.animate({left:"-240px"},{duration:d.animationSpeed});return c=!1}s.animate({left:"240px"},{duration:d.animationSpeed});u.animate({left:0},{duration:d.animationSpeed});return c=!0}});h=function(){u.find("li ul").slideUp(200);if(d.responsivePattern==="off-canvas"&&e(".flexmenu.fm-sm").length)return function(){u=e(".flexmenu.fm-sm");s.animate({left:0},{duration:d.animationSpeed});u.animate({left:"-240px"},{duration:d.animationSpeed});return c=!1}()};p=function(){var t;t=f.width();if(t<=d.breakpoint){if(e(".fm-lg").length){h();u.hasClass("fm-toggle")&&u.hide()}u.removeClass("fm-lg").addClass("fm-sm");i.show();o.off("mouseenter mouseleave");a.off("click");return a.on("click",function(t){var n,r;t.stopPropagation();r=e(this);n=r.parent(".with-ul").children("ul");return n.stop(!0,!0).slideToggle({duration:d.animationSpeed})})}h();u.removeClass("fm-sm").addClass("fm-lg");i.hide();u.hasClass("fm-toggle")&&u.slideDown();o.off("mouseenter mouseleave");a.off("click");return o.on("mouseenter",function(){return e(this).children("ul").stop(!0,!0).slideDown(d.animationSpeed)}).on("mouseleave",function(){return e(this).children("ul").stop(!0,!0).slideUp(d.animationSpeed)})};p();return f.resize(function(){clearTimeout(v);return v=setTimeout(p,200)})})}})(jQuery,window)}).call(this);