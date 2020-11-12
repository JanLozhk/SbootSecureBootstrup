package app.configuration;

public class UserSuccessHandler /*implements AuthenticationSuccessHandler*/ {
   /* @Override
    public void onAuthenticationSuccess(
            HttpServletRequest httpServletRequest,
            HttpServletResponse httpServletResponse,
            Authentication authentication
    ) throws IOException, ServletException {
        boolean isAdmin = authentication.getAuthorities().contains(new SimpleGrantedAuthority("ADMIN"));
        httpServletResponse.sendRedirect(isAdmin ? "/admin" : "/user");
    }*/
}
