from fastapi import FastAPI, Depends, HTTPException
from sqlalchemy.orm import Session
import crud,models, schemas
from database import SessionLocal, engine


models.Base.metadata.create_all(bind=engine)

app = FastAPI()

#Dependency
def get_db():
    db = SessionLocal()
    try : 
        yield db
    finally:
        db.close()


@app.post("/users/",response_model=schemas.User)
def post_user(user:schemas.UserCreate, db:Session=Depends(get_db)):
    db_user = crud.get_user_by_email(db, email=user.email)
    if db_user:
        raise HTTPException(status_code=400, detail="Email already registered")
    return crud.create_user(db=db,user=user)


@app.get("/users/", response_model=list[schemas.User])
def get_users(skip:int=0, limit:int=0, db:Session=Depends(get_db)):
    users = crud.get_users(db,skip=skip,limit=limit)
    return users


@app.get("/users/{user_id}/",response_model=schemas.User)
def get_user(user_id:int, db:Session=Depends(get_db)):
    db_user = crud.get_user(db,user_id =user_id )
    if db_user is None:
        raise HTTPException(status_code=404, detail="User not found")
    return db_user


@app.post("/users/{user_id}/bands/",response_model=schemas.Band)
def post_band_for_user(user_id:int, band:schemas.BandCreate, db:Session=Depends(get_db)):
    return crud.create_user_band(db=db,user_id=user_id, band=band)


@app.get("/bands/", response_model=list[schemas.Band])
def get_bands(skip:int=0,limit:int=100,db:Session=Depends(get_db)):
    bands = crud.get_bands(db,skip=skip,limit=limit)
    return bands

@app.post("/bands/{band_id}/backlog/", response_model=schemas.SongBacklog)
def post_backlog_for_band(band_id:int, backlog:schemas.SongBacklogCreate, db:Session=Depends(get_db)):
    return crud.create_band_songBacklog(db,band_id=band_id,backlog=backlog)

