FROM archlinux:base

RUN pacman -Syuu --noconfirm jre21-openjdk-headless wget tar
WORKDIR /root
RUN wget https://github.com/varabyte/kobweb-cli/releases/download/v0.9.17/kobweb-0.9.17.tar; tar -xvf kobweb-0.9.17.tar; rm *.tar; mv kobweb-* /opt/kobweb
ENV PATH="$PATH:/opt/kobweb/bin"