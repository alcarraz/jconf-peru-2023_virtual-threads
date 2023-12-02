\ProvidesClass{presentacion}

\LoadClass[aspectratio=169]{beamer}


\RequirePackage{fontawesome}


% Define default accent colors
\definecolor{basecolor}{HTML}{0000F0}       %BLUE

\colorlet{linkcolor}{basecolor}
\colorlet{accentcolor}{linkcolor!90}
\colorlet{symbolcolor}{linkcolor!85}



% Render a text with its symbol
% Usage; \socialtext{<icon>}{<label>}
\newcommand{\socialtext}[2]{\mbox{\textcolor{symbolcolor}{#1}\hspace{0.5em}#2\hspace{1em}}}
% Font Awesome icons aliases
\newcommand{\mailSymbol}{\faAt}
\newcommand{\locationSymbol}{\faMapMarker}
\newcommand{\infoSymbol}{\faInfo}
\newcommand{\blogSymbol}{\faRssSquare}
\newcommand{\cvpdfSymbol}{\faFilePdfO}
\newcommand{\linkedinSymbol}{\faLinkedinSquare}%{\faLinkedin}
\newcommand{\viadeoSymbol}{\faViadeo}
\newcommand{\mobileSymbol}{\faMobilePhone}
\newcommand{\githubSymbol}{\faGithub}
\newcommand{\stackOverflowSymbol}{\faStackOverflow}

\newcommand\link[2]{\color{linkcolor}\href{#1}{#2}\color{black} }


% Define author's tagline
% Usage: \tagline{<tag line>}
\newcommand*{\tagline}[1]{\def\@tagline{#1}}

% Define author's photo
% Usage \photo{<diameter>}{<photo>}
\newcommand{\photo}[2]{\def\@photo{#2}\def\@photodiameter{#1}}

% Render author's address
% Usage: \address{<address>}
\newcommand*{\address}[1]{\socialtext{\locationSymbol}{#1}}

% Render author's infos
% Usage: \infos{<infos>}
\newcommand*{\infos}[1]{\socialtext{\infoSymbol}{#1}}

% Render a link with its symbol
% Usage; \sociallink{<icon>}{<label>}
\newcommand{\sociallink}[3]{\mbox{\textcolor{symbolcolor}{#1}\hspace{0.5em}\link{#2}{#3}\hspace{1em}}}


% Render author's blog
% Usage: \blog{<blog>}
\newcommand*{\blog}[1]{\sociallink{\blogSymbol}{http://www.#1}{\underline{#1}}}

% Render author's PDF CV
% Usage: \cvpdf{<cvpdf>}
\newcommand*{\cvpdf}[1]{\sociallink{\cvpdfSymbol}{http://www.#1}{\underline{#1}}}

% Render author's linked-in (optional)
% Usage: \linkedin{<linked-in-nick>}
\newcommand*{\linkedin}[1]{\sociallink{\linkedinSymbol}
    {http://www.linkedin.com/in/#1}{\underline{linkedin.com/in/#1}}}

% Render author's viadeo(optional)
% Usage: \viadeo{<viadeo-nick>}
\newcommand*{
        \viadeo
    }
    [1]
    {
        \sociallink{\viadeoSymbol}
            {http://www.viadeo.com/fr/profile/#1}
            {viadeo.com/fr/profile/#1}
    } 

% Render author's github (optional)
% Usage: \github{<github-nick>}
\newcommand*{\github}[1]{\sociallink{\githubSymbol}
    {https://www.github.com/#1}{\underline{github.com/#1}}}

% Render author's email (optional)
% Usage: \email{<email adress>}
\newcommand*{\email}[1]{\sociallink{\mailSymbol}{mailto:#1}{\underline{#1}}}

% Render author's mobile phone (optional)
% Usage: \smartphone{<mobile phone number>}
\newcommand*\smartphone[1]{\socialtext{\mobileSymbol}{#1}}    

% Render author's stack overflow
\newcommand*{\stackoverflow}[1]{\sociallink{\stackOverflowSymbol}{https://stackoverflow.com/users/#1}{\underline{stackoverflow/#1}}}

% twitter
\newcommand*{\twitter}[1]{\sociallink{\faTwitter}{https://x.com/users/#1}{\underline{X/#1}}}
