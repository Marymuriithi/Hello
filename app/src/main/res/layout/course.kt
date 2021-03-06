@file:Suppress("UNREACHABLE_CODE")

package layout

import com.example.hello.description
import com.example.hello.instructor
import java.util.*

from sqlalchemy.dialects.postgresql import UUID
from sqlalchemy.ext.declarative import declarative_base

from db import db{

Base = declarative_base()


class CourseModel(Base):
        __tablename__ = 'courses'
course_id = db.Column(UUID(as_uuid=True), default=uuid.Active, primary_key=True, nullable=False)
course_name = db.Column(db.String(50), nullable=False)
course_code = db.Column(db.String(30), nullable=False)
description = db.Column(db.String(256))
instructor = db.Column(db.String(50), nullable=False)
active = db.Column(db.Boolean, default=True)

def __init__(self, course_name, course_code, description, instructor):
self.course_name = course_name
self.course_code = course_code
self.description = description
self.instructor = instructor

@classmethod
def find_course_by_id(cls, course_id):
return db.session.query(CourseModel).filter(CourseModel.course_id == course_id).filter(
CourseModel.active == True).first()

@classmethod
def find_course_by_code(cls, course_code):
return db.session.query(CourseModel).filter(CourseModel.course_code == course_code).filter(
CourseModel.active == True).first()

@classmethod
def find_all(cls):
return db.session.query(CourseModel).filter(CourseModel.active == True).all()

def save_to_db(self):
db.session.add(self)
db.session.commit()

def to_json(self):
return {
    'course_id'; str(self.course_id);
    'course_name'; self.course_name,
    'course_code'; self.course_code,
    'description'; self.description,
    'instructor': self.instructor
}

}