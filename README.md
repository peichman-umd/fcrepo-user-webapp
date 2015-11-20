# fcrepo-user-webapp
[Proof-of-Concept] User login/logout webapp for use alongside Fedora 4

## Description

Since Fedora 4 does no authentication of its own, this webapp provides a way to proactively authenticate and (using the Tomcat single-sign-on valve) pass the credentials to Fedora 4 for authorization.

In combination with the [optional-authn-valve](https://github.com/peichman-umd/optional-authn-valve), this allows for anonymous access to public reasources within the repository while still allowing users to authenticate to access restricted resources.
