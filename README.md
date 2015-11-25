# fcrepo-user-webapp
[Proof-of-Concept] User login/logout webapp for use alongside Fedora 4

## Usage

* `mvn clean package` and place the WAR file in `/var/lib/tomcat7/webapps`
* Enable the Tomcat Single-Sign-On valve in `/var/lib/tomcat7/conf/server.xml`

## Description

Since Fedora 4 does no authentication of its own, this webapp provides a way to proactively authenticate and (using the Tomcat single-sign-on valve) pass the credentials to Fedora 4 for authorization.

In combination with the [optional-authn-valve](https://github.com/peichman-umd/optional-authn-valve), this allows for anonymous access to public reasources within the repository while still allowing users to authenticate to access restricted resources.
