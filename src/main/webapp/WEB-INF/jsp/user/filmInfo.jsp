<jsp:directive.include file="../header.jsp"/>
<%--@elvariable id="film" type="com.ness.movie_release_notifier.model.OmdbFullWrapper"--%>

<div class="mytext panel panel-default">

    <div class="row">
        <div class="col-md-2">
            <img src="${film.poster}" width="200">
            <p/>

            <c:choose>
                <c:when test="${subscribed}">
                    <form action="/user/unSubscribe" method="post">
                        <input type="hidden" name="imdbId" value="${film.imdbId}"/>
                        <input type="submit" value="Unsubscribe" class="btn btn-success"/>
                    </form>
                </c:when>
                <c:otherwise>
                    <form action="/user/subscribe" method="post">
                        <input type="hidden" name="imdbId" value="${film.imdbId}"/>
                        <input type="submit" value="Subscribe" class="btn btn-primary"/>
                    </form>
                </c:otherwise>
            </c:choose>
        </div>
        <div class="col-md-8">
            <div class="row">

                <div class="col-md-8">
                    <div class="panel panel-default"><h3>${film.title} (${film.year})</h3></div>
                </div>
                <div class="col-md-4">
                    <div class="panel panel-default"><h3>Type: ${film.type}</h3></div>
                </div>
            </div>
            <div class="row">
                <div class="col-md-2">
                    <div class="panel panel-default">
                        <h5>Rated: ${film.rated}</h5>
                    </div>
                </div>
                <div class="col-md-2">
                   <div class="panel panel-default">
                       <h5>Runtime: ${film.runtime}</h5>
                   </div>
                </div>
                <div class="col-md-4">
                    <div class="panel panel-default">
                        <h5>Genres: ${film.genres}</h5>
                    </div>
                </div>
                <div class="col-md-4">
                    <div class="panel panel-default">
                        <h5>Director: ${film.director}</h5>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-md-4">
                    <div class="panel panel-default">
                        <h4>Released: ${film.released}</h4>
                    </div>
                </div>
                <div class="col-md-3 ">
                    <div class="panel panel-default">
                        <h5>Landuage: ${film.language}</h5>
                    </div>
                </div>
                <div class="col-md-3 ">
                    <div class="panel panel-default">
                        <h5>Country: ${film.country}</h5>
                    </div>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-md-4 ">
                <div class="panel panel-default">
                    <h5>Actors: ${film.actors}</h5>
                </div>
            </div>
            <div class="col-md-4 ">
                <div class="panel panel-default"><h5>Writers: ${film.writers}</h5></div>
            </div>
        </div>
    </div>

    <div class="row">
        <div class="col-md-12 ">
            <div class="panel panel-default"> Plot: ${film.plot}</div>
        </div>

    </div>

    <div class="row">
        <div class="col-md-2">
            <div class="panel panel-default"><h5> Metascore: ${film.metascore}</h5></div>
        </div>
        <div class="col-md-2">
            <div class="panel panel-default"><h5> Imdb Rating: ${film.imdbRating}</h5></div>
        </div>
        <div class="col-md-3">
            <div class="panel panel-default"><h5> DVD Release Date: ${film.dvd}</h5></div>
        </div>
        <div class="col-md-3">
            <div class="panel panel-default"><h5> Production: ${film.production}</h5></div>
        </div>
        <div class="col-md-2">
            <div><div class="panel panel-default"><h5><a href="${film.website}"> Website </a></h5></div></div>
        </div>
    </div>

</div>
<jsp:include page="../footer.jsp"/>