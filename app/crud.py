from sqlalchemy.orm import Session
import models,schemas


def get_user(db: Session, user_id: int):
    return db.query(models.User).filter(models.User.id == user_id).first()


def get_user_by_email(db: Session, email: str):
    return db.query(models.User).filter(models.User.email == email).first()


def get_users(db: Session, skip:int=0, limit:int=100):
    # return db.query(models.User).offset(skip).limit(limit).all()
    return db.query(models.User).offset(skip).limit(limit).all()


def create_user(db: Session, user:schemas.UserCreate):
    db_user = models.User(email=user.email,
                          name=user.name)
    db.add(db_user)
    db.commit()
    db.refresh(db_user)
    return db_user


def get_bands(db: Session, skip:int=0, limit: int=100):
    return db.query(models.Band).offset(skip).limit(limit).all()


def create_user_band(db:Session, band:schemas.BandCreate, user_id : int):
    db_band = models.Band(**band.model_dump(),owner_id=user_id )
    db.add(db_band)
    db.commit()
    db.refresh(db_band)
    return db_band

def create_band_songBacklog(db: Session, backlog:schemas.SongBacklogCreate, band_id: int):
    db_backlog = models.SongBacklog(**backlog.model_dump(),band_id=band_id)
    db.add(db_backlog)
    db.commit()
    db.refresh(db_backlog)
    return db_backlog

# NOTE :
# - add that instance object to your database session.
# - commit the changes to the database (so that they are saved).
# - refresh your instance (so that it contains any new data from the database, like the generated ID).
